// WAP to print the given amount of numbers in a spiral
// INPUT: 25
// [Output:]
// 21 22 23 24 25
// 20  7  8  9 10
// 19  6  1  2 11
// 18  5  4  3 12
// 17 16 15 14 13
#include<stdio.h>
#include<math.h>
int digits(int num)
{
  int digits=1;
  for(int i=10; num>=i ; digits++, i*=10);
  return digits;
}
void main()
{
  int in;
  printf("Enter a Number: ");
  scanf("%d",&in);
  const int size=(int) ceil(sqrt(in)), digit=digits(in);
  int gutter=(size*size)-in;
  int matrix[size][size];
  int row[]={0, size-1};
  int col[]={0, size-1};
  for(int j=size*size; j; j--)
  {
    for(int i=col[1]; i>=col[0]; i--)
      matrix[row[0]][i]=gutter-->0?0:in--;
    row[0]++;
    for(int i=row[0]; i<=row[1]; i++)
      matrix[i][col[0]]=gutter-->0?0:in--;
    col[0]++;
    for(int i=col[0]; i<=col[1]; i++)
      matrix[row[1]][i]=gutter-->0?0:in--;
    row[1]--;
    for(int i=row[1]; i>=row[0]; i--)
      matrix[i][col[1]]=gutter-->0?0:in--;
    col[1]--;
  }
  for(int i=0; i<size; i++, printf("\n"))
    for(int j=0; j<size; j++)
    {
      for(int k=digits(matrix[i][j]); k <= digit; k++, printf(" "));
      if(matrix[i][j])
        printf(" %d",matrix[i][j]);
      else
        printf("  ");
    }
}
