package org.gjt.sp.jedit.gui;


import javax.swing.JButton;
import javax.swing.tree.TreePath;
import java.io.Serializable;
import javax.swing.JTree;

public class FilesChangedDialogUpdateButtons implements Serializable {
	private JButton reload;
	private JButton ignore;

	public JButton getReload() {
		return reload;
	}

	public void setReload(JButton reload) {
		this.reload = reload;
	}

	public JButton getIgnore() {
		return ignore;
	}

	public void setIgnore(JButton ignore) {
		this.ignore = ignore;
	}

	public void updateEnabled(JTree thisBufferTree) {
		TreePath[] paths = thisBufferTree.getSelectionPaths();
		boolean enabled = false;
		if (paths != null) {
			for (TreePath tp : paths) {
				Object[] path = tp.getPath();
				if (path.length == 3)
					enabled = true;
			}
		}
		if (reload != null)
			reload.setEnabled(enabled);
		if (ignore != null)
			ignore.setEnabled(enabled);
	}
}