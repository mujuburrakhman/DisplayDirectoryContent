package com.project.display.displayfiles;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 
 * @author Mujubur
 *
 */
public class DisplayContentController {
	/** Implemented Logger here **/
	final static Logger LOG = Logger.getLogger(DisplayContentController.class);

	public DisplayContentController() {
	}

	/**
	 * This method decides which class need to be called based on the scenario
	 * 
	 * @param deciderString
	 * @param dir (inputDirectory)
	 * @return
	 */

	public List<String> getDirectoryList(final Decider decider, final File dir) {
		LOG.info("Input directory : " + dir);
		List<String> dirList = null;
		try {
			switch (decider) {
			case GETALL: {
				LOG.debug("GETALL Called");
				final DisplayContent displayContent = new GetAllContents();
				dirList = displayContent.displayContent(dir);
				break;
			}
			case GETDIRECTORY: {
				LOG.debug("GETDIRECTORY info only Called");
				final DisplayContent displayContent = new GetDirectoryInfo();
				dirList = displayContent.displayContent(dir);
				break;
			}
			case GETFILES: {
				LOG.debug("GETFILES info only Called");
				final DisplayContent displayContent = new GetFileInfo();
				dirList = displayContent.displayContent(dir);
				break;

			}
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
			dirList = null;
		}
		return dirList;
	}

}
