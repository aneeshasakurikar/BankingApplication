import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';


const routes: Routes = [
  // {path:'set-pass',component:SetNewPasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
