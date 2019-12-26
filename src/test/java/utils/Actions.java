package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Actions {

	public void createFolder(String path) {
		Path evidence_path = Paths.get(path);
		if (!Files.exists(evidence_path)) {
			File file = new File(path);
			file.mkdir();
		}
	}
}
