int n=arr.length;
        for(int i=0;i<n-1;i++){
            int imin=i;
            for(int j=i;j<n-1;j++){
               if(isSmaller(arr,j+1,imin))
                    imin=j+1;
            }
            swap(arr,i,imin);
        }