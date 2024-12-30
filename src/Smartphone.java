public class Smartphone {
    private int year;
    private int battery;
    private int chargingMinutes;

    public void setYear(int year) {
        this.year = year;
    }

    public boolean needsCharging() {
        if (this.battery <= 15) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBatteryFull () {
        if(this.battery==100)
        {
            return true;
        }
        else
            return false;
    }

    public boolean isNewPhone(){
        if(this.year>=2022)
        {
            return true;
        }
        else
            return false;
    }

    public boolean charge(int minutes) {
        if (isBatteryFull()) {
            return false;
        } else if (this.year == 2024) {
            this.chargingMinutes += minutes;
            this.battery += minutes;
        } else if (isNewPhone()) {
            this.chargingMinutes += minutes;
            this.battery += minutes * 0.75;
        }
    }

}


