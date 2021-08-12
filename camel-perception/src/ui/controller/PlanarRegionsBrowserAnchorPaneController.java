package ui.controller;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class PlanarRegionsBrowserAnchorPaneController extends Group
{
	@FXML
	private Button btnBrowse;
	@FXML
	private Button btnTempCreate;
	@FXML
	private Button btnClear;

	public void browse()
	{
		System.out.println("browse");
	}

	public void tempCreate()
	{
		System.out.println("tempCreate");
	}

	public void clear()
	{
		System.out.println("clear");
	}
}