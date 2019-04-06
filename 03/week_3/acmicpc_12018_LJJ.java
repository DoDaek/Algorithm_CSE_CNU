import java.util.*;

public class BackJoon12018 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int subject, mileage,count=0;
        ArrayList<Integer> applyList;

        subject = sc.nextInt();
        mileage = sc.nextInt();

        applyList = new ArrayList<>();

        for (int subjectIndex = 0; subjectIndex < subject; subjectIndex++){
            int applyCount = sc.nextInt();
            int allocationCount = sc.nextInt();
            List<Integer> mileageList = new ArrayList<>();
            for (int applyCountIndex =0; applyCountIndex < applyCount; applyCountIndex++){
                mileageList.add(sc.nextInt());
            }
            Collections.sort(mileageList);
            if (allocationCount > applyCount) applyList.add(1);
            else applyList.add(mileageList.get(applyCount-allocationCount));
        }

        Collections.sort(applyList);
        for (int index = 0; index < applyList.size(); index++){
            mileage = mileage - applyList.get(index);
            if (mileage >= 0) count++;
        }

        System.out.println(count);
    }
}
