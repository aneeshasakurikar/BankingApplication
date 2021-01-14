import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImpsFormComponent } from './imps-form.component';

describe('ImpsFormComponent', () => {
  let component: ImpsFormComponent;
  let fixture: ComponentFixture<ImpsFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImpsFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImpsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
