//
//  UrgentViewController.h
//  Hydra
//
//  Created by Pieter De Baets on 05/12/12.
//  Copyright (c) 2012 Zeus WPI. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface UrgentViewController : UIViewController

@property (nonatomic, assign) IBOutlet UIButton *play;
@property (nonatomic, assign) IBOutlet UIButton *pause;

-(IBAction)streamPlay:(id)sender;
-(IBAction)streamPause:(id)sender;

@end