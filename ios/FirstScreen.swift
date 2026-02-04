//
//  ViewController.swift
//  learn_ios_uikit
//
//  Created by Pham Hong on 4/2/26.
//

import UIKit

class FirstScreen: UIViewController {
    
    let headerView = UIHeaderMiniApp()

    override func viewDidLoad() {
        super.viewDidLoad()
        
        view.backgroundColor = .systemBackground
        setupHeader()
        
        let miniApp = MiniApp(frame: view.bounds)
                miniApp.autoresizingMask = [.flexibleWidth, .flexibleHeight]
                view.addSubview(miniApp)
    }
    
    func setupHeader() {
        view.addSubview(headerView)
        
        headerView.translatesAutoresizingMaskIntoConstraints = false
            
        headerView.setTitle("Mini App")
        
        NSLayoutConstraint.activate([
                    headerView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
                    headerView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
                    headerView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
                    headerView.heightAnchor.constraint(equalToConstant: 56)
                ])
    }
}
