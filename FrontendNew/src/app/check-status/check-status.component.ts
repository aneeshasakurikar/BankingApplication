import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-check-status',
  templateUrl: './check-status.component.html',
  styleUrls: ['./check-status.component.css']
})
export class CheckStatusComponent implements OnInit {
  refId;
  constructor(private http: HttpClient,private router:Router) { }

  ngOnInit() {
  }
  checkStatus(){
    console.log(this.refId)
    this.http.get<any>("http://localhost:8084/checkStatus/"+this.refId)
      .subscribe(response=>{
        alert(JSON.stringify(response.message));
      })
      this.router.navigate(['']);
    }
}
