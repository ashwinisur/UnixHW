package HW02;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class HistogramPane_Common extends Pane {
	private int[] numbers;
	private int coloredBarIndex = -1;
	private int low = 0; 
	private int high = -1; // Don't display the low and high area initially
	private int searchtype;
//searchType is 1 for linear search and 0 for binary search
	
	
	public void setNumbers(int searchtype, int[] numbers) {
		this.numbers = numbers;
		this.searchtype = searchtype;
		repaint();
	}

	public void setColoredBarIndex( int coloredBarIndex) {
		this.coloredBarIndex = coloredBarIndex;
		repaint();
	}
	
	public void setColoredBarIndex( int low, int high) {
		if(searchtype == 1)
			coloredBarIndex = high;
		else{
			this.low = low;
			this.high = high;
		}
		repaint();
	}

	public void repaint(){
		if(searchtype == 1)
			ls_repaint();
		else 
			b_repaint();
	}

	public void b_repaint() {
		// Find maximum integer
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (max < numbers[i]) {
				max = numbers[i];
			}
		}

		this.getChildren().clear();

		double height = getHeight() * 0.88;
		double width = getWidth() - 20;
		double unitWidth = width * 1.0 / numbers.length;

		int mid = (low + high) / 2;

		for (int i = 0; i < numbers.length; i++) {
			Rectangle bar =  new Rectangle(i * unitWidth + 10, getHeight()
					- (numbers[i] * 1.0 / max) * height, unitWidth, (numbers[i] * 1.0 / max) * height);

			if (i <= high && i >= low) {
				bar.setFill(Color.GRAY);
			}
			else {
				bar.setFill(Color.WHITE);
			}

			if (high != -1 && i == mid) {
				bar.setFill(Color.RED);
			}

			bar.setStroke(Color.BLACK);

			this.getChildren().add(bar);
			this.getChildren().add(new Text(i * unitWidth + 10 + 10,
					getHeight() - (numbers[i] * 1.0 / max) * height - 10,
					numbers[i] + ""));
		}
	}


	public void ls_repaint() {
		// Find maximum integer
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (max < numbers[i]) {
				max = numbers[i];
			}
		}

		this.getChildren().clear();

		double height = getHeight() * 0.88;
		double width = getWidth() - 20;
		double unitWidth = width * 1.0 / numbers.length;
		for (int i = 0; i < numbers.length; i++) {
			Rectangle bar =  new Rectangle(i * unitWidth + 10, getHeight()
					- (numbers[i] * 1.0 / max) * height, unitWidth, (numbers[i] * 1.0 / max) * height);
			bar.setFill(Color.WHITE);
			bar.setStroke(Color.BLACK);
			this.getChildren().add(bar);
			this.getChildren().add(new Text(i * unitWidth + 10 + 10,
					getHeight() - (numbers[i] * 1.0 / max) * height - 10,
					numbers[i] + ""));
		}

		if (coloredBarIndex >= 0) {
			int i = coloredBarIndex;
			Rectangle filledRectangle = new Rectangle(i * unitWidth + 10, getHeight()
					- (numbers[i] * 1.0 / max) * height, unitWidth, (numbers[i] * 1.0 / max) * height);
			filledRectangle.setFill(Color.RED);
			this.getChildren().add(filledRectangle);
		}
	}
}