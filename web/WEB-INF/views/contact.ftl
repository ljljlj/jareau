<@default.layout "Contact Manager">
<form method="post" action="addContact.html">
  <div class="form-group">
      <label for="firstName">First Name</label>
      <input class="form-control" name="firstName" />
  </div>
  <div>
      <label for="lastName">Last Name</label>
      <input class="form-control" name="lastName" />
  </div>
  <div>
      <label for="email">Email</label>
      <input class="form-control" name="email" />
  </div>
  <div>
      <label for="telephone">Telephone</label>
      <input class="form-control" name="telephone" />
  </div>
  <button class="btn btn-default" type="submit">Add contact</button>
</form>
</@default.layout>
