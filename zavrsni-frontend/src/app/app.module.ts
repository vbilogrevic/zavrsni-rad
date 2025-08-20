import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { MenuBarComponent } from './components/menu-bar/menu-bar.component';
import { SensorDisplayComponent } from './components/sensor-display/sensor-display.component';
import { SensorAverageComponent } from './components/sensor-average/sensor-average.component'; // napravi ovo

@NgModule({
  declarations: [
    AppComponent,
    SensorDisplayComponent, // non-standalone
    SensorAverageComponent,     // non-standalone
    MenuBarComponent        // non-standalone
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }