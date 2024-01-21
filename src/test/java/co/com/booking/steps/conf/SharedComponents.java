package co.com.booking.steps.conf;

import io.appium.java_client.AppiumDriver;

public class SharedComponents {

  private AppiumDriver driver;

  public AppiumDriver getDriver() {
    return driver;
  }
  
  public void setDriver(AppiumDriver driver) {
    this.driver = driver;
  }
}
