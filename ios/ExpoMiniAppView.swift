import ExpoModulesCore

class ExpoMiniAppView: ExpoView {
    
    let headerView = UIHeaderMiniApp()
    
    required init(appContext: AppContext? = nil) {
        super.init(appContext: appContext)
        clipsToBounds = true
        
        backgroundColor = .systemBackground
        setupHeader()
        setupMiniApp()
    }

    func setupHeader() {
        addSubview(headerView)
        headerView.translatesAutoresizingMaskIntoConstraints = false
        headerView.setTitle("Mini App")
        
        NSLayoutConstraint.activate([
            headerView.topAnchor.constraint(equalTo: safeAreaLayoutGuide.topAnchor),
            headerView.leadingAnchor.constraint(equalTo: leadingAnchor),
            headerView.trailingAnchor.constraint(equalTo: trailingAnchor),
            headerView.heightAnchor.constraint(equalToConstant: 50)
        ])
    }

    func setupMiniApp() {
        let miniApp = MiniApp()
        miniApp.translatesAutoresizingMaskIntoConstraints = false
        addSubview(miniApp)
        
        NSLayoutConstraint.activate([
            miniApp.topAnchor.constraint(equalTo: headerView.bottomAnchor),
            miniApp.leadingAnchor.constraint(equalTo: leadingAnchor),
            miniApp.trailingAnchor.constraint(equalTo: trailingAnchor),
            miniApp.bottomAnchor.constraint(equalTo: bottomAnchor)
        ])
    }
}
