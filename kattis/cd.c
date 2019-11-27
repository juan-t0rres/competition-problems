#include <stdio.h>
#include <stdlib.h>

int binarySearch(int* arr, int lo, int hi, int key)
{
  int mid;
  if(lo > hi)
    return 0;
  mid = (lo+hi)/2;
  if(arr[mid] == key)
    return 1;
  else if(arr[mid] > key)
    binarySearch(arr,lo,mid-1,key);
  else
    binarySearch(arr,mid+1,hi,key);
}

int main(void)
{
  int n, m, i, cd, count;
  int* jackCD;
  scanf("%d %d", &n, &m);
  while(n!=0 && m!=0)
  {
    jackCD = malloc(sizeof(int)*n);
    count = 0;
    for(i=0; i<n; i++)
      scanf("%d",&jackCD[i]);
    for(i=0; i < m; i++)
    {
      scanf("%d",&cd);
      if(binarySearch(jackCD,0,n,cd)==1)
        count++;
    }
    free(jackCD);
    jackCD = NULL;
    printf("%d\n",count);
    scanf("%d %d", &n, &m);
  }
  return 0;
}
