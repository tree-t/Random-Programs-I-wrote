// WAP to print the given amount of numbers in a spiral
// INPUT: 25
// [Output:]
// 21 22 23 24 25
// 20  7  8  9 10
// 19  6  1  2 11
// 18  5  4  3 12
// 17 16 15 14 13
import java.io.*;
class Spiral
{
  private int digits(int num)
  {
    int digit=1;
    for(int i=1; num>=i; digit++, i*=10);
    return digit;
  }
  private void printf(String s)
  {
    System.out.print(s);
  }
  private void calc()
  {
    try
    {
      BufferedReader br=new BufferedReader(new InputStreamReader( System.in));
      printf("Enter a Number: ");
      int in= Integer.parseInt(br.readLine());
      final int size=(int) Math.ceil(Math.sqrt(in)), digit=digits(in);
      int gutter=size*size-in;
      int matrix[][]=new int[size][size];
      int row[]={0, size-1};
      int col[]={0, size-1};
      for(int j=0; j<size*size; j++)
      {
        for(int i=col[1]; i>=col[0]; i--)
          matrix[row[0]][i]=gutter--<=0?in--:0;
        row[0]++;
        for(int i=row[0]; i<=row[1]; i++)
          matrix[i][col[0]]=gutter--<=0?in--:0;
        col[0]++;
        for(int i=col[0]; i<=col[1]; i++)
          matrix[row[1]][i]=gutter--<=0?in--:0;
        row[1]--;
        for(int i=row[1]; i>=row[0]; i--)
          matrix[i][col[1]]=gutter--<=0?in--:0;
        col[1]--;
      }
      for(int i=0; i<size; i++, printf("\n"))
        for(int j=0; j<size; j++)
         {
           for(int k=digits(matrix[i][j]); k <= digit; k++, printf(" "));
           printf(" "+(matrix[i][j]==0?' ':matrix[i][j]));
         }
    }
    catch(Exception e)
    {
      printf("The input must be a number.\n");
    }
  }
  public static void main(String[]args)
  {
    Spiral obj1=new Spiral();
    obj1.calc();
  }
}
