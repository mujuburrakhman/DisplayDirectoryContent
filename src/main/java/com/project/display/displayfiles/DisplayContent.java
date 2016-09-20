package com.project.display.displayfiles;

import java.io.File;
import java.util.List;

/**
 * 
 * @author Mujubur Rakhman
 *
 */
public interface DisplayContent {
	/**
	 * This method display the content for of directory(repository)
	 * 
	 * @param dir
	 * @return
	 */
	List<String> displayContent(final File dir);
}
