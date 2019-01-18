import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesafioBodyComponent } from './desafio-body.component';

describe('DesafioBodyComponent', () => {
  let component: DesafioBodyComponent;
  let fixture: ComponentFixture<DesafioBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesafioBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesafioBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
