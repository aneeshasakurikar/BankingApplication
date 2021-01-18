import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Beneficiary } from '../models/models';
import { ServicesService } from '../services/services.service';

@Component({
  selector: 'app-add-beneficiary',
  templateUrl: './add-beneficiary.component.html',
  styleUrls: ['./add-beneficiary.component.css']
})
export class AddBeneficiaryComponent implements OnInit {

  benf: Beneficiary = new Beneficiary();

  constructor(private service: ServicesService, private router:Router) { }

  addBeneficiary() {
    this.service.addBeneficiary(this.benf).subscribe(response => {
      
          alert(JSON.stringify(response.message));
          this.router.navigate(['neftPayment']);
        
      
      
    })
    
  }

  ngOnInit() {
  }

}
