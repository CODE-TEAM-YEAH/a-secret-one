public class UserInterface{
  private array readables;
  private array audioProducts;
  private int currentPage; // the page number (P1..P10)
  
  public int getCurrentPage(page){// This method is for page navigation. Based on the values of the state variable, call different pages
    currentPage = page
  }
  public int changeCurrentPage(page){// This method is for page navigation. It should change to current page and show the content.
  public void getReadables(); // Fetches all readables from the files and places them in the readables array
  public void getAudioProducts(); // Fetches all audio products from the files and places them in the readables array
  public void showReadables(); // Displays all readables for browsing
  public void showAudioProducts(); // Displays all audio products for browsing
  //more methods
}
