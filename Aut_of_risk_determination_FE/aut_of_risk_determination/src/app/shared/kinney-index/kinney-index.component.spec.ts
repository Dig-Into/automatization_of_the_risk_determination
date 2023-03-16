import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KinneyIndexComponent } from './kinney-index.component';

describe('KinneyIndexComponent', () => {
  let component: KinneyIndexComponent;
  let fixture: ComponentFixture<KinneyIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KinneyIndexComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KinneyIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
