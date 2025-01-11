/**

Design an in-memory  file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. 
    If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. 
    If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content.
    If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.

Example:

Input:
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]

Output:
[null,[],null,null,["a"],"hello"]

Note:

You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.

*/

// Definition for a Trie Node which is used internally in FileSystem.
class TrieNode {
    String name; // Name of the file or directory
    boolean isFile; // Flag indicating whether it is a file or not
    StringBuilder content = new StringBuilder(); // Content of the file if it is a file
    Map<String, TrieNode> children = new HashMap<>(); // Child nodes, representing files and directories

    // Method to insert a node and return the last node in the path.
    TrieNode insert(String path, boolean isFile) {
        TrieNode node = this;
        String[] parts = path.split("/");

        for (int i = 1; i < parts.length; ++i) {
            String part = parts[i];
            if (!node.children.containsKey(part)) {
                node.children.put(part, new TrieNode());
            }
            node = node.children.get(part);
        }

        node.isFile = isFile;
        if (isFile) {
            node.name = parts[parts.length - 1]; // Set the name of the file
        }

        return node;
    }

    // Method to search for a node given a path.
    TrieNode search(String path) {
        TrieNode node = this;
        String[] parts = path.split("/");

        for (int i = 1; i < parts.length; ++i) {
            String part = parts[i];
            if (!node.children.containsKey(part)) {
                return null; // Node not found
            }
            node = node.children.get(part);
        }

        return node; // Node found
    }
}

// Definition of a FileSystem that uses a TrieNode structure to manage files and directories.
class FileSystem {
    private TrieNode root = new TrieNode(); // Root directory of the file system

    // Constructor for the FileSystem
    public FileSystem() {
        // The root does not need any initial setup.
    }

    // List the contents in a directory or return the file if it's just a single file.
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        TrieNode node = root.search(path);
        if (node == null) {
            return result; // Empty list if path not found
        }
      
        if (node.isFile) {
            // If it's a file, add the file name to the result list
            result.add(node.name);
        } else {
            // If it's a directory, add all the child names to the list
            result.addAll(node.children.keySet());
        }
        Collections.sort(result); // Sort the list lexicographically
        return result;
    }

    // Make a directory given a path.
    public void mkdir(String path) {
        root.insert(path, false);
    }

    // Add content to the file, create the file if it does not exist.
    public void addContentToFile(String filePath, String content) {
        TrieNode node = root.insert(filePath, true);
        node.content.append(content); // Append the content to the file's content
    }

    // Read content from a file.
    public String readContentFromFile(String filePath) {
        TrieNode node = root.search(filePath);
        if (node != null && node.isFile) {
            return node.content.toString(); // Return file content as a String
        }
        return ""; // Return empty String if file does not exist or if it's a directory
    }
}

/*
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath, content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
