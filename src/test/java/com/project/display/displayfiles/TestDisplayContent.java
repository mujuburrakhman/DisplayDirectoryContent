package com.project.display.displayfiles;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.project.display.displayfiles.Decider;
import com.project.display.displayfiles.DisplayContentController;

/**
 * 
 * @author Mujubur Rakhman
 *
 */
public class TestDisplayContent {
	private final static Logger LOG = Logger.getLogger(DisplayContentController.class);
	private DisplayContentController controllerOBJ;
	final File sourceDir = new File("src/test/resources");

	@Test
	public void testALLDirectoryFileContents() throws Exception {
		controllerOBJ = new DisplayContentController();
		final List<String> dirList = controllerOBJ.getDirectoryList(Decider.GETALL,sourceDir);
		if (dirList != null) {
			for (final String output : dirList) {
				LOG.info(output);
			}
		}
		assertNotNull(dirList);
	}
	
	@Test 
	public void testDirectoryContents() throws Exception {
		controllerOBJ = new DisplayContentController();
		final List<String> dirList = controllerOBJ.getDirectoryList(Decider.GETDIRECTORY,sourceDir);
		if (dirList != null) {
			for (final String output : dirList) {
				LOG.info(output);
			}
		}
		assertNotNull(dirList);
	}
	
	@Test
	public void testFileContents() throws Exception {
		controllerOBJ = new DisplayContentController();
		final List<String> dirList = controllerOBJ.getDirectoryList(Decider.GETFILES,sourceDir);
		if (dirList != null) {
			for (final String output : dirList) {
				LOG.info(output);
			}
		}
		assertNotNull(dirList);
	}

}
