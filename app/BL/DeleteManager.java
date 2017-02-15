package BL;

import java.util.*;
import DL.*;
import objects.*;

public class DeleteManager {
	private static DLLManager dm;
	private static queryManager qm;
	
	public int deleteProduct(String name) {
		if(dm == null)
			dm = new DLLManager();
		return dm.deleteProduct(name);
	}
}
