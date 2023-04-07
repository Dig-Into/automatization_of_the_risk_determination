import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcenaRizikaComponent } from './procena-rizika.component';

describe('ProcenaRizikaComponent', () => {
  let component: ProcenaRizikaComponent;
  let fixture: ComponentFixture<ProcenaRizikaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcenaRizikaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProcenaRizikaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
