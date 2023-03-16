import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcenaRizikaPregledComponent } from './procena-rizika-pregled.component';

describe('ProcenaRizikaPregledComponent', () => {
  let component: ProcenaRizikaPregledComponent;
  let fixture: ComponentFixture<ProcenaRizikaPregledComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcenaRizikaPregledComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProcenaRizikaPregledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
