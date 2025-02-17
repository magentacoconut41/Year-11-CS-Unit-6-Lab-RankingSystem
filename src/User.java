public class User {
    int rank;
    int progress;

    public User(){
        rank = -8;
        progress = 0;
    }

    public int getProgress() {
        return progress;
    }

    public void incProgress(int taskRank){
        int difference;
        int progressIncrease;
        if(taskRank < -8 || taskRank == 0 || taskRank > 8){
            System.out.println("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }else{
            if (taskRank > 0 && this.rank < 0) {
                difference = taskRank - this.rank - 1;
            } else if (taskRank < 0 && this.rank > 0) {
                difference = taskRank - this.rank + 1;
            } else {
                difference = taskRank - this.rank;
            }
            if (difference == -1) {
                progressIncrease = 1;
            } else if (difference == 0) {
                progressIncrease = 3;
            } else if (difference > 0) {
                progressIncrease = 10 * difference * difference;
            } else {
                progressIncrease = 0;
            }
            this.progress += progressIncrease;
            while(progress > 100){
                if(this.rank == -1){
                    this.rank = 1;
                    progress -= 100;
                }else if(this.rank == 8){
                    this.progress = 100;
                }else{
                    this.rank++;
                    progress -= 100;
                }
            }
        }
    }
}
