import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MereComponent } from './mere.component';

describe('MereComponent', () => {
  let component: MereComponent;
  let fixture: ComponentFixture<MereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MereComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
