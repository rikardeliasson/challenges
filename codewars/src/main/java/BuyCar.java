public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {

        int latestPriceOld = startPriceOld;
        int latestPriceNew = startPriceNew;
        int[] result = new int[2];
        int months = 1;
        if(startPriceOld > startPriceNew) {
            result[0] = 0;
            result[1] = startPriceOld - startPriceNew;
        }
        else {
            while(latestPriceOld + (savingperMonth * months) < latestPriceNew) {
                if(months%2 == 0) {
                    percentLossByMonth += 0.005;
                }
            //for (months = 1; latestPriceOld + (savingperMonth * months) < latestPriceNew; months++) {
                latestPriceOld = startPriceOld - ((int) (latestPriceOld * (percentLossByMonth/100)));
                latestPriceNew = startPriceNew - ((int) (latestPriceNew * (percentLossByMonth/100)));
                System.out.println("PriceOld: " + latestPriceOld + "PriceNew: " + latestPriceNew + "savedAmount: " + savingperMonth*months + "months: " + months);
                months++;
            }
            result[0] = months;
            result[1] = latestPriceOld + (savingperMonth*months) - latestPriceNew;
        }


        return result;
    }
}