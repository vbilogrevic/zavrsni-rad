import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SensorAverageComponent } from './components/sensor-average/sensor-average.component';
import { SensorDisplayComponent } from './components/sensor-display/sensor-display.component';

const routes: Routes = [
  { path: 'lastdata', component: SensorDisplayComponent },
  { path: 'otherpage', component: SensorAverageComponent },
  { path: '', redirectTo: '/lastdata', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }