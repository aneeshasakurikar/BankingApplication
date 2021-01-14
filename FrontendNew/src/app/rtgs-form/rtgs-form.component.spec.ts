import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RtgsFormComponent } from './rtgs-form.component';

describe('RtgsFormComponent', () => {
  let component: RtgsFormComponent;
  let fixture: ComponentFixture<RtgsFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RtgsFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RtgsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
