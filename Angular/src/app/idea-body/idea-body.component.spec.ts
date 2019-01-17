import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeaBodyComponent } from './idea-body.component';

describe('IdeaBodyComponent', () => {
  let component: IdeaBodyComponent;
  let fixture: ComponentFixture<IdeaBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeaBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeaBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
