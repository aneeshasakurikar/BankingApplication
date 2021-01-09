import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NetbankingRegistrationComponent } from './netbanking-registration.component';

describe('NetbankingRegistrationComponent', () => {
  let component: NetbankingRegistrationComponent;
  let fixture: ComponentFixture<NetbankingRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NetbankingRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NetbankingRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
