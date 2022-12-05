package Database;

import App.Workspace;

public class GatewayWorkspace implements Gateway<Workspace> {

    @Override
    public Workspace find(int id) {
        return null;
    }

    @Override
    public boolean create(Workspace obj) {
        return false;
    }

    @Override
    public boolean update(Workspace obj) {
        return false;
    }

    @Override
    public boolean delete(Workspace obj) {
        return false;
    }
}
