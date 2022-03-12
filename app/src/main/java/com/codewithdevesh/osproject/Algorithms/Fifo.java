package com.codewithdevesh.osproject.Algorithms;

public class Fifo {
    int totalHits;
    public int[][] performFifo(int[] pages, int frames) {
        int[]buffer = new int[frames];
        int[][]layout = new int[pages.length][frames];
        int pointer=0,hit=0,fault=0;
          for(int j=0;j<frames;j++){
              buffer[j]=-1;
          }

          for(int i=0;i< pages.length;i++){
              int search=-1;
              for(int j=0;j<frames;j++){
                  if(buffer[j]==pages[i]){
                      search=j;
                      hit++;
                      break;
                  }
              }
              if(search==-1){
                  buffer[pointer]=pages[i];
                  fault++;
                  pointer++;
                  if(pointer==frames){
                      pointer=0;
                  }
              }

              for(int j=0;j<frames;j++){
                  layout[i][j]=buffer[j];
              }
          }
          totalHits=hit;
          return layout;
    }
    public int getHits(){
        return totalHits;
    }
}
