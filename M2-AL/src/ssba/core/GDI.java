package ssba.core;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameframework.core.Game;
import gameframework.core.GameLevelDefaultImpl;;

public class GDI extends GameLevelDefaultImpl{
	public GDI(Game g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	private Frame f;

	@SuppressWarnings("unused")
	private void createMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("file");
		MenuItem start = new MenuItem("new game");
		MenuItem save = new MenuItem("save");
		MenuItem restore = new MenuItem("load");
		MenuItem quit = new MenuItem("quit");
		menuBar.add(file);
		f.setMenuBar(menuBar);

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		restore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restore();
			}
		});
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});


		file.add(start);
		file.add(save);
		file.add(restore);
		file.add(quit);

	}

	public void restore() {
		System.out.println("restore command isn't ready");
	}

	public void save() {
		System.out.println("save command isn't ready");
	}

	public void pause() {
		System.out.println("pause command isn't ready");
	}


	@Override
	protected void init() {
		// TODO Auto-generated method stub

	}

}
