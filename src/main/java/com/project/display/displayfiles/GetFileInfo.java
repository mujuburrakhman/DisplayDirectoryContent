package com.project.display.displayfiles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
/**
 * Contains some methods to list files and folders from a directory
 *
 * @author Mujubur Rakhman
 */
public class GetFileInfo implements DisplayContent{
	/** Implemented Logger here **/
	private final static Logger LOG = Logger.getLogger(GetFileInfo.class);
	private static List<String> finalList;
     
	/**
	 * Override method of DisplayContent
	 */
	public List<String> displayContent(final File dir) {
		finalList = new ArrayList<String>();
		GetFileInfo.iterateContents(dir);		
		return finalList;
	}
	
    /**
     * List all the files under a directory
     * @param dir to be listed
     */
    public static void iterateContents(final File dir) {
		try {
			
			final File[] files = dir.listFiles();
			if(files==null){
				throw new Exception("No Directory found for the given input or invalid directory");
			}
			for (final File file : files) {
				if (file.isDirectory()) {
					iterateContents(file);
				} else {
					finalList.add(file.getCanonicalPath());
				}
			}
			
		} catch (IOException e) {
			LOG.error(e.getMessage());
			finalList.clear();
		}
		catch (Exception e) {
			LOG.error(e.getMessage());
			finalList.clear();
		}
    }
    
   
}