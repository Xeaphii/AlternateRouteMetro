package route.alternate.xeaphii.com.alternateroute;

/**
 * Created by Sunny on 9/1/2015.
 */
public class TrainPojo {
    String Station1,Station2,ArrivalTime,DepatureTime,TrainName,TravelTime,RunsOnDays,ClassesAvailable;
    public TrainPojo(String Station1,String Station2,String ArrivalTime,String DepatureTime
            ,String TrainName,String TravelTime,String RunsOnDays,String ClassesAvailable){
    this.Station1 = Station1;
        this.Station2 = Station2;
        this.ArrivalTime = ArrivalTime;
        this.DepatureTime = DepatureTime;
        this.TrainName = TrainName;
        this.TravelTime = TravelTime;
        this.RunsOnDays = RunsOnDays;
        this.ClassesAvailable = ClassesAvailable;
    }
}
