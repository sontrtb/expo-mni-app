//
//  CustomHeaderView.swift
//  learn_ios_uikit
//
//  Created by Pham Hong on 4/2/26.
//

import UIKit

class UIHeaderMiniApp: UIView {
    
    let backButton = UIButton(type: .system)
    let closeButton = UIButton(type: .system)
    let titleLabel = UILabel()
    
    // Closures để handle button actions
    var onBackTapped: (() -> Void)?
    var onCloseTapped: (() -> Void)?
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupView()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupView()
    }
    
    private func setupView() {
        backgroundColor = .white
        
        // Back button
        backButton.setImage(UIImage(systemName: "chevron.left"), for: .normal)
        backButton.tintColor = .black
        backButton.addTarget(self, action: #selector(backButtonTapped), for: .touchUpInside)
        
        // Close button
        closeButton.setImage(UIImage(systemName: "xmark"), for: .normal)
        closeButton.tintColor = .black
        closeButton.addTarget(self, action: #selector(closeButtonTapped), for: .touchUpInside)
        
        // Title label
        titleLabel.textAlignment = .left
        titleLabel.font = UIFont.systemFont(ofSize: 18, weight: .semibold)
        titleLabel.textColor = .black
        
        // Add subviews
        addSubview(backButton)
        addSubview(closeButton)
        addSubview(titleLabel)
        
        // Disable autoresizing mask
        backButton.translatesAutoresizingMaskIntoConstraints = false
        closeButton.translatesAutoresizingMaskIntoConstraints = false
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        
        // Setup constraints
        NSLayoutConstraint.activate([
            // Back button constraints
            backButton.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            backButton.centerYAnchor.constraint(equalTo: centerYAnchor),
            backButton.widthAnchor.constraint(equalToConstant: 40),
            backButton.heightAnchor.constraint(equalToConstant: 40),
            
            // Close button constraints
            closeButton.trailingAnchor.constraint(equalTo: trailingAnchor, constant: -16),
            closeButton.centerYAnchor.constraint(equalTo: centerYAnchor),
            closeButton.widthAnchor.constraint(equalToConstant: 40),
            closeButton.heightAnchor.constraint(equalToConstant: 40),
            
            // Title label constraints
            titleLabel.leadingAnchor.constraint(equalTo: backButton.trailingAnchor, constant: 4),
            titleLabel.centerYAnchor.constraint(equalTo: centerYAnchor),
            titleLabel.trailingAnchor.constraint(lessThanOrEqualTo: closeButton.leadingAnchor, constant: -4)
        ])
    }
    
    @objc private func backButtonTapped() {
        onBackTapped?()
    }
    
    @objc private func closeButtonTapped() {
        onCloseTapped?()
    }
    
    // Convenience method để set title
    func setTitle(_ title: String) {
        titleLabel.text = title
    }
    
    // Methods để ẩn/hiện buttons nếu cần
    func hideBackButton(_ hidden: Bool) {
        backButton.isHidden = hidden
    }
    
    func hideCloseButton(_ hidden: Bool) {
        closeButton.isHidden = hidden
    }
}
