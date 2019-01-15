import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VistaListComponent } from './vista-list.component';

describe('VistaListComponent', () => {
  let component: VistaListComponent;
  let fixture: ComponentFixture<VistaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VistaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VistaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
