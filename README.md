<h3>/ / / / / / / / / / / / / / / / / / / / MOBILE / / / / / / / / / / / / / / / / / / / /</h3>
<h3>Test the functionality of name showing in welcome title</h3>
<p><i>(Verifying that name is correct in welcome title)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the Welcome page → Welcome page is opened;</li>
  <li>Click on the settings button → Settings page is opened;</li>
  <li>Take name from 'Your name' → Name is taken;</li>
  <li>Click on the back button → Welcome page is opened.</li>
</ol>
<h4>Expected result:</h4> Name in welcome title is the same as in the settings page.

<br><br>

<h3>Test the functionality of creating new box</h3>
<p><i>(Verifying that new box was created)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the Welcome page → Welcome page is opened;</li>
  <li>Click on the 'Add New Box' button → Add new box page is opened;</li>
  <li>Type name of the box (e.g.: “Animals”) → Name was typed (e.g.: “Animals”);</li>
  <li>Click on the 'Create Box' button → Welcome page is opened.</li>
</ol>
<h4>Expected result:</h4> New box with some name (e.g.: “NewBox”) is present in welcome page.

<br><br>

<h3>Test the functionality of creating new card</h3>
<p><i>(Verifying that new card was created)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the Welcome page → Welcome page is opened and box with some name (e.g.: “Animals”) is present;</li>
  <li>Click on the box with the same name (e.g.: “Animals”) → Box page is opened;</li>
  <li>Click on the 'Add Card' button → Add card page is opened;</li>
  <li>Type front side of the card (e.g.: “Cat”) → Front side was typed (e.g.: “Cat”);</li>
  <li>Type back side of the card (e.g.: “An animal with four legs”) → Back side was typed (e.g.: “An animal with four legs”);</li>
  <li>Click on the done button → Box page is opened.</li>
</ol>
<h4>Expected result:</h4> New card with some name (e.g.: “Cat”) is present in the box page.

<br><br>

<h3>Test the functionality of deleting the card</h3>
<p><i>(Verifying that card was deleted)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the Welcome page → Welcome page is opened and box with some name (e.g.: “Animals”) is present;</li>
  <li>Click on the box with the same name (e.g.: “Animals”) → Box page is opened;</li>
  <li>Click on the edit card with some name (e.g.: “Cat”) → Edit card page is opened;</li>
  <li>Click on the 'Delete Card' button → Box page is opened.</li>
</ol>
<h4>Expected result:</h4> Card with some name (e.g.: “Cat”) is not present in the box page.

<br><br>

<h3>Test the functionality of deleting the box</h3>
<p><i>(Verifying that box was deleted)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the Welcome page → Welcome page is opened and box with some name (e.g.: “Animals”) is present;</li>
  <li>Click on the box with the same name (e.g.: “Animals”) → Box page is opened;</li>
  <li>Click on the settings button → 'Delete' button is present;</li>
  <li>Click on the 'Delete' button → Welcome page is opened.</li>
</ol>
<h4>Expected result:</h4> Box with some name (e.g.: “Animals”) is not present in the welcome page.

<br><br>

<h3>/ / / / / / / / / / / / / / / / / / / / / WEB / / / / / / / / / / / / / / / / / / / / /</h3>

<h3>Test the functionality of product search</h3>
<p><i>(Verifying the product search by entering a brand name and ensuring that the title of each product card contains that brand name)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the page https://epicentrk.ua/ → Page https://epicentrk.ua/ is opened;</li>
  <li>Enter the brand name into the search line (e.g.: “Apple”) → Inscription is displayed in the search line (e.g.: “Apple”);</li>
  <li>Click on the search button → Search page is opened.</li>
</ol>
<h4>Expected result:</h4> Each product card should contain the brand name.

<br><br>

<h3>Test the functionality of adding a product to the cart</h3>
<p><i>(Verifying if products are successfully added to the cart)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the page https://epicentrk.ua/ → Page https://epicentrk.ua/ is opened;</li>
  <li>Click on the “Каталог товарів” button → Select with categories is opened;</li>
  <li>Click on the category (e.g.: “Електроніка”) → Page with types of goods is opened;</li>
  <li>Click on the good type (e.g.: “Мобільні телефони”) → Page with types of goods is opened;</li>
  <li>Click on the good type (e.g.: “Смартфони”) → Page with goods is opened;</li>
  <li>Click on the add to cart button on the product → Cart form is opened;</li>
  <li>Click on the close button of the cart → Cart form is closed;</li>
  <li>Click on the add to cart button on the same product again → Cart form is opened.</li>
</ol>	
<h4>Expected result:</h4> The quantity of the same type of product in the cart equals 2.

<br><br>

<h3>Test the discount and promotion filter</h3>
<p><i>(Verifying if the order total reflects the applied promotion)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the page https://epicentrk.ua/ → Page https://epicentrk.ua/ is opened;</li>
  <li>Click on the category card named “Електроніка” → Page with types of goods is opened;</li>
  <li>Click on the some good type (e.g.: “Мобільні телефони”) → Page with types of goods is opened;</li>
  <li>Click on the some good type (e.g.: “Смартфони”) → Page with goods is opened;</li>
  <li>Navigate to the section named “акції” → Section with promotion is opened;</li>
  <li>Click on the add to cart button on the product → Cart form is opened;</li>
  <li>Click on the “Оформити покупку” button → Order page is opened.</li>
</ol>
<h4>Expected result:</h4> The order summary displays the total amount with the applied promotion near “усього до сплати”

<br><br>

<h3>Test the price filter functionality</h3>
<p><i>(Verifying the display of product prices on cards when setting an upper price limit)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the page https://epicentrk.ua/ → Page https://epicentrk.ua/ is opened;</li>
  <li>Enter the brand name into the search line (e.g.: “Apple”) → Inscription is displayed in the search line (e.g.: “Apple”);</li>
  <li>Click on the search button → Search page is opened;</li>
  <li>Set the upper price limit (e.g.: 500) → Upper limit is set.</li>
</ol>
<h4>Expected result:</h4> All products on the page do not have a price higher than the set limit.

<br><br>

<h3>Test user login verification</h3>
<p><i>(Verifying whether the user can successfully log in)</i></p>
<h4>Steps:</h4>
<ol>
  <li>Go to the page https://epicentrk.ua/ → Page https://epicentrk.ua/ is opened;</li>
  <li>Click on the “Увійти” button → Login form is opened;</li>
  <li>Enter the phone number → Phone field is filled;</li>
  <li>Enter the password → Password field is filled;</li>
  <li>Click on the “Увійти” button → Page https://epicentrk.ua/ is opened.</li>
</ol>
<h4>Expected result:</h4> The user has successfully logged in, button “Увійти” is despaired.
