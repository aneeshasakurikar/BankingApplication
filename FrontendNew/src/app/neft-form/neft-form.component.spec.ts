import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NeftFormComponent } from './neft-form.component';

describe('NeftFormComponent', () => {
  let component: NeftFormComponent;
  let fixture: ComponentFixture<NeftFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NeftFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NeftFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
