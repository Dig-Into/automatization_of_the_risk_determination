import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerePregledComponent } from './mere-pregled.component';

describe('MerePregledComponent', () => {
  let component: MerePregledComponent;
  let fixture: ComponentFixture<MerePregledComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerePregledComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MerePregledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
