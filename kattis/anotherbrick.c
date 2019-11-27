#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  int i,h,w,n,c, *bricks;
  c = 0;
  scanf("%d %d %d",&h,&w,&n);
  bricks = malloc(sizeof(int)*n);
  for(i = 0; i < n; i++)
  {
    scanf("%d",&bricks[i]);
    c += bricks[i];
    if(c == w)
    {
      c = 0;
    }
    else if(c > w)
    {
      printf("NO\n");
      return 0;
    }
  }
  printf("YES\n");
  return 0;
}
