package com.codewithdevesh.osproject.Algorithms;

public class Optimal {
    int totalHits;
    final static int MAX_VAL=Integer.MAX_VALUE;

//    public int getHits(int[]pages,int f){
//
//        int frames, pointer = 0, hit = 0, fault = 0;
//        boolean isFull = false;
//        int buffer[];
//        int reference[];
//        int mem_layout[][];
//
//        /*-------------------initializing the arrays----------------*/
//        frames = f;
//        reference = new int[pages.length];
//        mem_layout = new int[pages.length][frames];
//        buffer = new int[frames];
//
//        for(int j = 0; j < frames; j++)
//            buffer[j] = -1;
//        /*-----------------------copying array--------------------*/
//        System.arraycopy(pages, 0, reference, 0, pages.length);
//
//        for(int i = 0; i < pages.length; i++){
//            int search = -1;
//            for(int j = 0; j < frames; j++){
//                if(buffer[j] == reference[i]){
//                    search = j;
//                    hit++;
//                    break;
//                }
//            }
//
//            if(search == -1){
//                if(isFull){
//                    int index[] = new int[frames];
//                    boolean index_flag[] = new boolean[frames];
//                    for(int j = i + 1; j < pages.length; j++){
//                        for(int k = 0; k < frames; k++){
//                            if((reference[j] == buffer[k]) && (index_flag[k] == false)){
//                                index[k] = j;
//                                index_flag[k] = true;
//                                break;
//                            }
//                        }
//                    }
//                    int max = index[0];
//                    pointer = 0;
//                    if(max == 0)
//                        max = 200;
//                    for(int j = 0; j < frames; j++){
//                        if(index[j] == 0)
//                            index[j] = 200;
//                        if(index[j] > max){
//                            max = index[j];
//                            pointer = j;
//                        }
//                    }
//                }
//                buffer[pointer] = reference[i];
//                fault++;
//                if(!isFull){
//                    pointer++;
//                    if(pointer == frames){
//                        pointer = 0;
//                        isFull = true;
//                    }
//                }
//            }
//            for(int j = 0; j < frames; j++)
//                mem_layout[i][j] = buffer[j];
//        }
//        return hit;
//    }
    /*------------------function for getting layout for visualization---------------------*/
    public int[][] performOptimal(int[]pages,int frames){
        int pointer = 0, hit = 0, fault = 0;
        boolean isFull = false;
        int[] buffer;
        int[][] layout;

        /*-------------------initializing the arrays of layout and buffer----------------*/

        layout = new int[pages.length][frames];
        buffer = new int[frames];

        for(int j = 0; j < frames; j++)
            buffer[j] = -1;

        /*-----------------------copying array--------------------*/
        System.arraycopy(pages, 0, pages, 0, pages.length);

        /*-------------checking if pages doesn't exist then increase hit counter ----------------------*/
        for(int i = 0; i < pages.length; i++){
            int search = -1;
            for(int j = 0; j < frames; j++){
                if(buffer[j] == pages[i]){
                    search = j;
                    hit++;
                    break;
                }
            }

            if(search == -1){
                /* checking if the frames are full then we will remove the page which need is in last */
                if(isFull){
                    int[] index = new int[frames]; // for storing index of page
                    boolean[] index_flag = new boolean[frames];  // for checking
                    for(int j = i + 1; j < pages.length; j++){
                        for(int k = 0; k < frames; k++){
                            if((pages[j] == buffer[k]) && (!index_flag[k])){
                                index[k] = j;   // assuming j be the farthest index
                                index_flag[k] = true;
                                break;
                            }
                        }
                    }
                    /*-----------------assuming max which will store index of farthest index------------------*/
                    int max = index[0];
                    pointer = 0;
                    if(max == 0)
                        max = MAX_VAL;
                    for(int j = 0; j < frames; j++){
                        if(index[j] == 0)
                            index[j] = MAX_VAL;
                    /*-------------checking for farthest index-------------*/
                        if(index[j] > max){
                            max = index[j];
                            pointer = j;
                        }
                    }
                }
                /* checking in page already exist and frame is not full then increase fault counter*/
                buffer[pointer] = pages[i];
                fault++;
                if(!isFull){
                    pointer++;
                    /*------------------if the frame is full--------------*/
                    if(pointer == frames){
                        pointer = 0;
                        isFull = true;
                    }
                }
            }
            /*------------------copying elements int 2d array----------------*/
            System.arraycopy(buffer, 0, layout[i], 0, frames);
        }
        /*------------------------storing no of hits----------------*/
        totalHits=hit;

        return layout;
    }

    /*---------------- function for getting number of hits -----------------*/
    public int getHits(){
        return totalHits;
    }
}

/* complexity analysis
Time Complexity -  O(f)+0(n)+O(n*f*n)
Space Complexity -
 */


