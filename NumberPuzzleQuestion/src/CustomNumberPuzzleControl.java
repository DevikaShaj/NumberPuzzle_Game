import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		int click=15; boolean done=false;
		for(int k=0;k<16;k++) {
			if(buttons[k]==buttonClicked)
				click=k;
		}
		switch(emptyCellId) {
		case 0:
			if(click==1 || click==4) {
				swapButton(buttons[emptyCellId],buttonClicked);
				done = true;
			}
				
			
			break;
		case 3:
			if(click==2 || click==7) {
				swapButton(buttons[emptyCellId],buttonClicked);
				done = true;
			}
			break;
		case 12:
			if(click==8 || click==13) {
				swapButton(buttons[emptyCellId],buttonClicked);
				done = true;
			}				
			break;
		case 15:
			if(click==11 || click==14) {
				swapButton(buttons[emptyCellId],buttonClicked);
				done = true;
			}
			break;
		default:
			int a=emptyCellId+1;
			int b=emptyCellId+4;
			int c=emptyCellId-1;
			int d=emptyCellId-4;
			if(click==a || click==b || click==c || click==d) {
				swapButton(buttons[emptyCellId],buttonClicked);
				done = true;
			}
				
			
		}
		if(done) {
			for(int i=0;i<16;i++) {
				if(buttons[i]==buttonClicked)
					emptyCellId=i;
		}
		
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		int ind = 0;
		while(ind<15) {
			int a = getRandomNumber();
			boolean same = false;
			if(a>0 && a<16) {
				for(int i=0;i<=ind;i++) {
					if(arr[i]==a) {
						same = true;
						break;
					}									
				}
				if(!same) {
					arr[ind]=a;
					ind++;
				}
				
				
			}
		}		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] win=getIntegerArrayOfButtonIds(buttons);
		
		for(int j=0;j<14;j++) {
			if(win[j]>win[j+1]) {
				winner=false;
				break;
			}			
		}

		return winner;
	}
}