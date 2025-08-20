import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SensorDisplayComponent } from './app/components/sensor-display/sensor-display.component';
import { SensorAverageComponent } from './app/components/sensor-average/sensor-average.component'; // napravi ovu komponentu

const routes: Routes = [
  { path: 'lastdata', component: SensorDisplayComponent },
  { path: 'otherpage', component: SensorAverageComponent },
  { path: '', redirectTo: '/lastdata', pathMatch: 'full' } // default ruta
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
