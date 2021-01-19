import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NetbankingRegistration } from '../models/models';
import { ServicesService } from '../services/services.service';

@Component({
  selector: 'app-netbanking-registration',
  templateUrl: './netbanking-registration.component.html',
  styleUrls: ['./netbanking-registration.component.css']
})
export class NetbankingRegistrationComponent implements OnInit {

  credentials: NetbankingRegistration = new NetbankingRegistration();
  constructor(private service: ServicesService, private router:Router) { }

  ngOnInit() {
  }
  netbankingRegistration() {
    this.service.netbankingRegistration(this.credentials).subscribe(response => {
      
          alert(JSON.stringify(response.message));
          location.reload();
        }
      
      
    )

}
}
