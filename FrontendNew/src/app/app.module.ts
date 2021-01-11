import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { CheckStatusComponent } from './check-status/check-status.component';
import { NetbankingRegistrationComponent } from './netbanking-registration/netbanking-registration.component';
import { ForgotUserIdComponent } from './forgot-user-id/forgot-user-id.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

import { FormsModule } from '@angular/forms';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';

import { AdminLoginComponent } from './admin-login/admin-login.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    RegistrationPageComponent,
    LoginPageComponent,
    CheckStatusComponent,
    NetbankingRegistrationComponent,
    ForgotUserIdComponent,
    ForgotPasswordComponent,

    SetNewPasswordComponent,

    AdminLoginComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
